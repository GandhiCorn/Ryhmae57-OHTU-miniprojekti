import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Lisää uusi referenssi",{
    given "Luo referenssejä", {
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
        app = null

    }
    when "Avaa ohjelma uudelleen", {
        app = new Application()
        app.run(null)
    }
    then "Tarkista että referenssi on edelleen olemassa", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
    }
}
