package Peixo.IAdeTreinoPOKE.dto;

import java.util.List;

import lombok.Data;

@Data
public class PokeAPIDTO {


    private String name;
    private List<PokeType> types;
    private List<PokeStats> stats;

    public static class PokeType {
        private Type type;
        public Type getType() { return type; }
    }

    public static class Type {
        private String name;
        public String getName() { return name; }
    }

    public static class PokeStats {
        private int base_stat;
        private Stats stat;
        public int getBase_stat() { return base_stat; }
    }

    public static class Stats {
        private String name;
    }
}
