package ryhma57.references;

import java.io.Serializable;
import java.util.EnumMap;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.backend.ReferenceType;

public class Reference implements Serializable {

    private static final long serialVersionUID = 7162163400760877670l;
    private final ReferenceType referenceType;
    private EnumMap<BibtexReferenceField, String> fields;

    public Reference(ReferenceType referenceType) {
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        this.referenceType = referenceType;
    }

    public final String getID() {
        return this.fields.get(BibtexReferenceField.ID);
    }

    public final String getField(BibtexReferenceField field) {
        return fields.get(field);
    }

    public final ReferenceType getReferenceType() {
        return referenceType;
    }

    /*FIXME inform about the problems with exceptions */
    public final void setField(BibtexReferenceField field, String value) {
        if (!ReferenceFields.getAllFields(getReferenceType()).contains(field)) {
            //FIXME we should propably throw exception here.
            System.out.println("Invalid field");
        }
        fields.put(field, value);
    }

    final public String toBibTex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(referenceType.toString().toLowerCase()).append("{");
        sb.append(getID()).append(",\n");
        for (BibtexReferenceField field : this.fields.keySet()) {
            if (field == BibtexReferenceField.ID) {
                continue;
            }
            sb.append("\t").append(field.getName()).append(" = {");
            sb.append(fields.get(field)).append("},\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
