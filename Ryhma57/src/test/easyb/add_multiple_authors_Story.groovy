import ryhma57.backend.*
import ryhma57.gui.*
import ryhma57.references.*
import static ryhma57.backend.ReferenceType.*
import java.nio.file.Files
import java.nio.file.Paths

scenario "Lisää kaksi authoria", {
    given "Luo referenssi", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
        fields.put(BibtexReferenceField.TITLE, "Kotkan lento")
        fields.put(BibtexReferenceField.YEAR, "2002")
        fields.put(BibtexReferenceField.JOURNAL, "Otava")
    }
    when "Luo referenssi", {
        fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen, Obama")
        app.createNewReference(ARTICLE, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
        ((Reference)app.getList().get(0)).getAuthors().size().shouldBe 2
    }
}

scenario "Lisää monta authoria", {
    given "Luo referenssi", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
        fields.put(BibtexReferenceField.TITLE, "Kotkan lento")
        fields.put(BibtexReferenceField.YEAR, "2002")
        fields.put(BibtexReferenceField.JOURNAL, "Otava")
    }
    when "Luo referenssi", {
        fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen, Obama, Sauli")
        app.createNewReference(ARTICLE, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
        ((Reference)app.getList().get(0)).getAuthors().size().shouldBe 3
    }
}

scenario "Lisää tyhjiä authoria", {
    given "Luo referenssi", {
        Storage.removeTmpFiles()
        app = new Application()
        app.run(null)
        fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class)
        fields.put(BibtexReferenceField.ID, "test")
        fields.put(BibtexReferenceField.TITLE, "Kotkan lento")
        fields.put(BibtexReferenceField.YEAR, "2002")
        fields.put(BibtexReferenceField.JOURNAL, "Otava")
    }
    when "Luo referenssi", {
        fields.put(BibtexReferenceField.AUTHOR, "Matti Nykänen, , Sauli")
        app.createNewReference(ARTICLE, fields)
    }
    then "Tarkista että referenssi ollaan luotu", {
        app.getList().size().shouldBe 1
        (app.getList().get(0) instanceof Article).shouldBe true
        ((Reference)app.getList().get(0)).getAuthors().size().shouldBe 2
    }
}