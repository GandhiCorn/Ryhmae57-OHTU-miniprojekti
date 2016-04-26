import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Generoi BibTex tiedosto",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
    }
    when "Luo referenssi ja generoi database file", {
        app.createNewReference(BOOK, fields)
        app.generateBibTex()
    }
    then "Tarkista että tiedoston sisältö on merkkijono", {
        str = new String(Files.readAllBytes(Paths.get("references.bib")))
        str.shouldNotBe null
    }
}