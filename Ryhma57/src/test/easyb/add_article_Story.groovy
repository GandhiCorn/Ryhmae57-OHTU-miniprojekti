import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Lisää uusi referenssi",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Storage.removeTmpFiles()
        app = new Application()
        window = new Window(app)
        app.run(window)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
    }
    when "Luo referenssi", {
        app.createNewReference(ARTICLE, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
    }
}