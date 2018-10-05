package model;

public class Papel extends Identificador{
    private EnumPapeis desc;

    public EnumPapeis getDesc() {
        return desc;
    }

    public void setDesc(EnumPapeis desc) {
        this.desc = desc;
    }

    public Papel() {}

    public Papel(Long id, EnumPapeis desc) {
        super(id);
        this.setDesc(desc);
    }
}
