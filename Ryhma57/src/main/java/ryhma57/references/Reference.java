package ryhma57.references;

import java.util.EnumMap;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;

public abstract class Reference {
    protected final EnumSet<BibtexReferenceField> existingFields;
    protected final EnumSet<BibtexReferenceField> requiredFields;
    private EnumMap<BibtexReferenceField, String> fields;

    protected Reference(EnumSet<BibtexReferenceField> existingFields,
            EnumSet<BibtexReferenceField> requiredFields) {
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        this.existingFields = existingFields;
        this.requiredFields = requiredFields;
    }

    public final String getField(BibtexReferenceField field) {
        return fields.get(field);
    }

    public final void setField(BibtexReferenceField field, String value) {
        if(!existingFields.contains(field)) {
            //FIXME we should propably throw exception here.
            System.out.println("Invalid field");
            return;
        }
        fields.put(field, value);
    }

    abstract public String toBibTex();
}
