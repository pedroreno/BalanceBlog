package model;

public enum EnumPapeis {

    ADMINISTRADOR ("Administrador"),
    USUARIO_COMUM ("Usuário Comum"),
    VISITANTE ("Visitante");

    private final String desc;

    EnumPapeis (String desc) {this.desc = desc;}

    @Override
    public String toString() {return this.desc;}
}
