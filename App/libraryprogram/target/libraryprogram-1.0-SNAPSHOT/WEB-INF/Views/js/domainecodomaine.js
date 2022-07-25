function random() {
    alert("working");
    var a = document.getElementById("domaine").value;
    if (a === "Arts")
    {
        var arr = ['Architecture', 'Enseignement de l\'art', 'Histoire de l\'art', 'Danse', 'Design', 'Mode', 'Film',
            'Design graphique', 'Musique', 'Solfège', 'Peinture', 'Photographie'];
    } else if (a === "Animaux")
    {
        var arr = ['Ours', 'Chats', 'Chatons', 'Chiens', 'Chiots'];
    } else if (a === "Fiction")
    {
        var arr = ['Fantastique',
            'Roman historique',
            'Épouvante',
            'Humour',
            'Littérature',
            'Magie',
            'Policier',
            'Pièce de théâtre',
            'Poésie',
            'Romance',
            'Science-fiction',
            'Nouvelle',
            'Thriller',
            'Jeune adulte'];
    } else if (a === "Science & Mathématiques")
    {
        var arr = ['Biologie',
            'Chimie',
            'Mathématiques',
            'Physique',
            'Programmation'];
    } else if (a === "Économie & Finance")
    {
        var arr = ['Management',
            'Entrepreneuriat',
            'Économie',
            'Réussite d\'entreprise',
            'Finance'];
    } else if (a === "Fiction jeunesse")
    {
        var arr = ['Littérature pour enfants',
            'Histoire en rimes',
            'Petite enfance',
            'Histoire du soir',
            'Livre d\'images '];
    }
    /*else if (a === "USA")
     {
     var arr = ["Washington", "Texas", "New York"];
     }*/
















    var string = "";

    for (i = 0; i < arr.length; i++)
    {
        string = string + "<option value=" + arr[i] + ">" + arr[i] + "</option>";
    }
    document.getElementById("co_domaine").innerHTML = string;
}
   