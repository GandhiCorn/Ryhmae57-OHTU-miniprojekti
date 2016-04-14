import ryhma57.backend.*;
import ryhma57.gui.*;

scenario "Lisää uusi referenssi",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Application app = new Application()
        EnumMap<BibtexReferenceField, String> fields
        fields = new EnumMap<>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
    }
    when "Luo referenssi ja generoi database file", {
        app.createNewBookReference()
        app.generateBibTex()
    }
    then "Tarkista että tiedoston sisältö on merkkijono", {
        String str = new String(Files.readAllBytes(Paths.get("database.bib")))
        str.shouldNotBe null
    }
}