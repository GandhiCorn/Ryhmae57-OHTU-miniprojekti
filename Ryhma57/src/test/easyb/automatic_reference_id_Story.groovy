import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Automaattisesti luo id",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen")
        fields.put(BibtexReferenceField.TITLE, "Kotkan lento")
        fields.put(BibtexReferenceField.YEAR, "2002")
        fields.put(BibtexReferenceField.JOURNAL, "Otava")
    }
    when "Luo referenssi", {
        app.createNewReference(ARTICLE, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
        app.getList().get(0).getField(BibtexReferenceField.ID).shouldBe "M2002"
    }
}
