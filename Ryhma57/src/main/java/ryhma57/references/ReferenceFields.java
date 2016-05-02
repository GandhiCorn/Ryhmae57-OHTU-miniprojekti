/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma57.references;

import java.util.EnumMap;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.backend.ReferenceType;

/**
 *
 * @author rimi
 */
public class ReferenceFields {

    private final EnumSet<BibtexReferenceField> requiredFields;
    private final EnumSet<BibtexReferenceField> optionalFields;

    private static final EnumMap<ReferenceType, ReferenceFields> REFERENCE_FIELDS = new EnumMap<>(ReferenceType.class);

    static {
        REFERENCE_FIELDS.put(ReferenceType.BOOK, new Book());
        REFERENCE_FIELDS.put(ReferenceType.ARTICLE, new Article());
        REFERENCE_FIELDS.put(ReferenceType.INPROCEEDINGS, new Inproceedings());
        
        addMissingFieldSets();
    }

    private static void addMissingFieldSets() {
        for (ReferenceType referenceType : ReferenceType.values()) {
            REFERENCE_FIELDS.putIfAbsent(referenceType,
                    new ReferenceFields(
                            EnumSet.noneOf(BibtexReferenceField.class),
                            EnumSet.noneOf(BibtexReferenceField.class)
                    )
            );
        }
    }

    public ReferenceFields(EnumSet<BibtexReferenceField> requiredFields, EnumSet<BibtexReferenceField> optionalFields) {
        this.requiredFields = requiredFields;
        this.optionalFields = optionalFields;
    }

    /**
     * Returns the set of all fields for the reference type
     *
     * @param referenceType
     * @return
     */
    public static EnumSet<BibtexReferenceField> getAllFields(ReferenceType referenceType) {
        EnumSet<BibtexReferenceField> set = EnumSet.noneOf(BibtexReferenceField.class);
        ReferenceFields get = REFERENCE_FIELDS.get(referenceType);
        set.addAll(get.requiredFields);
        set.addAll(get.optionalFields);
        return set;
    }

    /**
     * Returns the set of required fields for the reference type
     *
     * @param referenceType
     * @return
     */
    public static EnumSet<BibtexReferenceField> getRequiredFields(ReferenceType referenceType) {
        ReferenceFields get = REFERENCE_FIELDS.get(referenceType);
        return get.requiredFields;
    }

    /**
     * Returns the set of optional fields for the reference type
     *
     * @param referenceType
     * @return
     */
    public static EnumSet<BibtexReferenceField> getOptionalFields(ReferenceType referenceType) {
        ReferenceFields get = REFERENCE_FIELDS.get(referenceType);
        return get.optionalFields;
    }

}
