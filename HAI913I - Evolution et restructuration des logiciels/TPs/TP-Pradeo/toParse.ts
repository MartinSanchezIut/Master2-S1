class Choix {
  constructor(fatherID, Qtext, Rtext, childs) {
      this.fatherID = fatherID;
      this.Qtext = Qtext;
      this.Rtext = Rtext;
      this.childs = childs;
  }

  // Getters
  getFather() {
      return this.fatherID;
  }
  getQtext() {
      return this.Qtext;
  }
  getRtext() {
      return this.Rtext;
  }
  getChilds() {
      return this.childs;
  }
}

function setQuestion(text, important) {
  let q = document.getElementById("question") ;
  q.innerHTML = text;
  // A voir
  if (important === "1") {
      listeImportant.push(text) ;
  }
}
// Supprime toutes les réponses
function clearReponses() {
  let repDiv = document.getElementById("divreponses") ;
  repDiv.innerHTML = "";
}

// Ajoute une réponse
function addReponse(id, text, action) {
  let repDiv = document.getElementById("divreponses") ;

  let child = document.createElement("p");
  //child.className = "rep card-panel grey lighten-2 z-depth-4";
  child.className ="rep card-panel vert z-depth-4 white-text"
  child.innerHTML = text;
  child.id = "rep" + id ;
  child.style.cursor = "pointer" ;
  repDiv.appendChild(child);

  child.addEventListener("click", action);
}

let visual = document.getElementById("visual") ;


let boutAjouter = document.getElementById("ajouter");

let boutModif = document.getElementById("modifier");
let ligneid = document.getElementById("ID");
let lblid = document.getElementById("lblID");

document.getElementById("annuler").addEventListener("click", cacherForm);
document.getElementById("ajouter").addEventListener("click", envoyerform);
document.getElementById("modifier").addEventListener("click", modifChoix);


afficherArbre();
