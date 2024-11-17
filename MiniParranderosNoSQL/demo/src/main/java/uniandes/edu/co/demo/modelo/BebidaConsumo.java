package uniandes.edu.co.demo.modelo;

public class BebidaConsumo {
    private String _id;
    private int total;

    public BebidaConsumo() {
    }

    public BebidaConsumo(String _id, int total) {
        this._id = _id;
        this.total = total;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BebidaConsumo{" +
                "_id='" + _id + '\'' +
                ", total=" + total +
                '}';
    }
}
