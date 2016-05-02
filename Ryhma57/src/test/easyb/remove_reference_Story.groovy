import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Poista referenssejä",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
        fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen")
        fields.put(BibtexReferenceField.TITLE, "Kotkan lento")
        fields.put(BibtexReferenceField.YEAR, "2002")
        fields.put(BibtexReferenceField.JOURNAL, "Otava")

        app.createNewReference(ARTICLE, fields)
    }
    when "Poista referenssi", {
        app.removeReference(0)
    }
    then "Tarkista että referenssi on poistettu", {
        app.getList().size().shouldBe 0
    }
}