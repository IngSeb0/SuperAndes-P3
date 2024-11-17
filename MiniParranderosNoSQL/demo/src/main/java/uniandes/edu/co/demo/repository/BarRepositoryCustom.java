package uniandes.edu.co.demo.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BarRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public BarRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Obtiene las bebidas más consumidas basado en bares frecuentados y preferencias.
     *
     * @return Lista de bebidas más consumidas con su cantidad.
     */
    public List<Document> obtenerBebidasMasConsumidas() {
        List<Document> pipeline = List.of(
            // Descomponer bares frecuentados en cada bebedor
            new Document("$unwind", "$bares_frecuentados"),
            // Hacer lookup en la colección de bares
            new Document("$lookup", new Document()
                .append("from", "bares")
                .append("localField", "bares_frecuentados")
                .append("foreignField", "_id")
                .append("as", "bar_detalle")
            ),
            // Descomponer los detalles del bar
            new Document("$unwind", "$bar_detalle"),
            // Descomponer la oferta de bebidas del bar
            new Document("$unwind", "$bar_detalle.oferta_bebidas"),
            // Descomponer las preferencias de cada bebedor
            new Document("$unwind", "$preferencias"),
            // Filtrar solo las bebidas que están en las preferencias de los bebedores
            new Document("$match", new Document()
                .append("$expr", new Document()
                    .append("$eq", List.of("$bar_detalle.oferta_bebidas.nombre", "$preferencias"))
                )
            ),
            // Agrupar por nombre de bebida y contar cuántas veces ha sido consumida
            new Document("$group", new Document()
                .append("_id", "$preferencias")
                .append("total", new Document()
                    .append("$sum", 1)
                )
            ),
            // Ordenar las bebidas por total en orden descendente
            new Document("$sort", new Document()
                .append("total", -1)
            ),
            // Limitar a las 3 más consumidas
            new Document("$limit", 3)
        );

        // Ejecutar la consulta en la colección "bebedores" y devolver el resultado
        return mongoTemplate.getCollection("bebedores").aggregate(pipeline).into(new java.util.ArrayList<>());
    }
}
