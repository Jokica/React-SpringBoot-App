export const listStudents = () => {
    return [{ Name: "Tino", Surname: "Tinovski", Indeks: "432432", Nasoka: "KNI" }, { Name: "Tino1", Surname: "Tinovski", Indeks: "4324321", Nasoka: "KNI1" },
           {Name: "Simona", Surname: "Simonovska", Indeks: "21321", Nasoka: "ASI"}, {Name: "Anton", Surname: "Trajkovski", Indeks: "23411", Nasoka: "KNI"},
           {Name: "Biljana", Surname: "Simonovska", Indeks: "542387", Nasoka: "ASI"}, {Name: "Petar", Surname: "Petrovikj", Indeks: "321563", Nasoka: "KNI"}];
}

export async function getAllStudents () {
    
    return fetch('http://localhost:9090/student')
    .then(function(response) {
      return response.json();
    })
    .then(function(myJson) {
       return myJson;
    })
    
}
