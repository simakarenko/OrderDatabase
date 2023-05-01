package ua.kiev.prog.shared;

import java.util.List;

public class Orders {
    @Id
    private int id;
    private int clId;
    private String prId;

    public Orders() {
    }

    public Orders(int clId, List<Integer> prId) {
        this.clId = clId;
        this.prId = parsingList(prId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(List<Integer> prId) {
        this.prId = parsingList(prId);
    }

    private String parsingList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            sb.append(n).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", clId=" + clId +
                ", prId=" + prId +
                '}';
    }
}
