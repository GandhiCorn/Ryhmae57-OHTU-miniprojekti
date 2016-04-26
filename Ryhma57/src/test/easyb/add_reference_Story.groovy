import ryhma57.backend.*
import ryhma57.gui.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Lisää uusi referenssi",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        app = new Application()
        window = new Window(app)
        app.run(window)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
    }
    when "Luo referenssi", {
        app.createNewBookReference(fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getListSize().shouldBe 1
    }
}