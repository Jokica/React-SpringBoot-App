import React, { Component } from 'react';
import './App.css';
import { listStudents } from './repository/StudentRepository';
import { StudentsList } from './components/StudentsList';
import { AddNewStudent } from './components/AddNewStudent';
class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      students: listStudents()
    }
  }
  handleChangeDetails = (index, student) =>{
      var students = this.state.students;
      students.splice(index, 1, student);
  }

  addStudent = (name, surname, index, nasoka) => {
    var student = {"Name": name, "Surname": surname, "Indeks": index, "Nasoka": nasoka};
    this.setState({
      students: [...this.state.students, student]
    })
  }

  deleteStudent = (index) => {
    var students = this.state.students;
    students.splice(index, 1);
    this.setState({students})
  }
  render() {
    return (
      <div className="App">
        <StudentsList students={this.state.students} handleChangeDetails={this.handleChangeDetails} deleteStudent={this.deleteStudent}/>
        <AddNewStudent handleSubmit={this.addStudent} />
      </div>
    );
  }
}

export default App;
