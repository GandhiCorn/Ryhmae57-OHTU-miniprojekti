package ryhma57.references;

import java.util.EnumMap;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;

public abstract class Reference {
    protected final EnumSet<BibtexReferenceField> existingFields;
    protected final EnumSet<BibtexReferenceField> requiredFields;
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
