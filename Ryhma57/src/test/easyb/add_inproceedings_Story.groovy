import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Lisää uusi inproceeding referenssi",{
    given "Applikaatio on olemassa ja meillä on fieldit", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
	fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen")
	fields.put(BibtexReferenceField.TITLE, "Tit")
	fields.put(BibtexReferenceField.BOOKTITLE, "Kirjan nimi")
	fields.put(BibtexReferenceField.YEAR, "2002")
    }
    when "Luo referenssi", {
        app.createNewReference(INPROCEEDINGS, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Inproceedings).shouldBe true
    }
}