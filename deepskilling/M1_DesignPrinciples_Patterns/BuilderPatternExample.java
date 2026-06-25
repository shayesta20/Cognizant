class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .build();

        Computer officePc = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("Gaming PC: " + gamingPc);
        System.out.println("Office PC: " + officePc);
    }
}
