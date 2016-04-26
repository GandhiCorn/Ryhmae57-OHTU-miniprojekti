import ryhma57.backend.*
import ryhma57.gui.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Generoi BibTex tiedosto",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        app = new Application()
        window = new Window(app)
        app.run(window)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
    }
    when "Luo referenssi ja generoi database file", {
        app.createNewBookReference(fields)
        app.generateBibTex()
    }
    then "Tarkista että tiedoston sisältö on merkkijono", {
        str = new String(Files.readAllBytes(Paths.get("references.bib")))
        str.shouldNotBe null
    }
}