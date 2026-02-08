package Enums;

public enum CategoriaProduto {

    ALIMENTO("Alimento"),
    TECNOLOGIA("Tecnologia"),
    ROUPA("Roupa");

        private String items;

    CategoriaProduto(String items) {
        this.items = items;
    }

    public String getItems() {
        return items;
    }
}
