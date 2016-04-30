package ryhma57.references;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;

public abstract class Reference implements Serializable {

    private static final long serialVersionUID = 7162163400760877670l;
    protected final EnumSet<BibtexReferenceField> requiredFields;
    protected final EnumSet<BibtexReferenceField> optionalFields;
    private final String referenceType;
    private EnumMap<BibtexReferenceField, String> fields;

    protected Reference(EnumSet<BibtexReferenceField> requiredFields,
            EnumSet<BibtexReferenceField> optionalFields,
            String referenceType) {
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        this.requiredFields = requiredFields;
        this.optionalFields = optionalFields;
        this.referenceType = referenceType;
    }

    public final String getID() {
        return this.fields.get(BibtexReferenceField.ID);
    }

    public final String getField(BibtexReferenceField field) {
        return fields.get(field);
    }

    public EnumSet<BibtexReferenceField> getExistingFields() {
        EnumSet<BibtexReferenceField> allFields = EnumSet.noneOf(BibtexReferenceField.class);
        allFields.addAll(requiredFields);
        allFields.addAll(optionalFields);
        return allFields;
    }

    public EnumSet<BibtexReferenceField> getRequiredFields() {
        return requiredFields;
    }

    /*FIXME inform about the problems with exceptions */
    public final void setField(BibtexReferenceField field, String value) {
        if (!getExistingFields().contains(field)) {
            //FIXME we should propably throw exception here.
            System.out.println("Invalid field");
        }
        fields.put(field, value);
    }

    final public String toBibTex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(this.referenceType).append("{");
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
