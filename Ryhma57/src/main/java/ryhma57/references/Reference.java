package ryhma57.references;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;

public abstract class Reference implements Serializable {
    private static final long serialVersionUID = 7162163400760877670l;
    protected final EnumSet<BibtexReferenceField> existingFields;
    protected final EnumSet<BibtexReferenceField> requiredFields;
    private final String referenceType;
    private EnumMap<BibtexReferenceField, String> fields;

    /**
     * Helper function for creating the field sets.
     *
     * @param fields
     * @return Set that contains all the fields given as arguments
     */
    protected static EnumSet<BibtexReferenceField> createFieldSet(BibtexReferenceField... fields) {
        EnumSet<BibtexReferenceField> set;
        set = EnumSet.noneOf(BibtexReferenceField.class);

        for (int i = 0; i < fields.length; ++i) {
            set.add(fields[i]);
        }
        return set;
    }

    protected static EnumSet<BibtexReferenceField> createExistingSet(
            EnumSet<BibtexReferenceField> required,
            EnumSet<BibtexReferenceField> optionals) {
        EnumSet<BibtexReferenceField> set;

        set = required.copyOf(optionals);
        set.addAll(required);
        return set;
    }

    protected Reference(EnumSet<BibtexReferenceField> existingFields,
            EnumSet<BibtexReferenceField> requiredFields,
            String referenceType) {
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        this.existingFields = existingFields;
        this.requiredFields = requiredFields;
        this.referenceType = referenceType;
    }

    public final String getID() {
        return this.fields.get(BibtexReferenceField.ID);
    }

    public final String getField(BibtexReferenceField field) {
        return fields.get(field);
    }
    
    public final EnumSet<BibtexReferenceField> getRequiredFields() {
        return this.requiredFields;
    }

    /*FIXME inform about the problems with exceptions */
    public final void setField(BibtexReferenceField field, String value) {
        if(!existingFields.contains(field)) {
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
