import React, { Component } from 'react';
import { StudentItem } from './StudentItem.js';
import { EditStudentDetails } from './EditStudentDetails';

export class StudentsList extends Component {
        constructor(props) {
                super(props);
                this.state = {
                        currentStudent: null,
                        currentIndex: null,
                }

        }

        handleClick = (student, index) => {
                this.setState({ currentStudent: student, currentIndex: index })
        }
        handleSubmit = (Name, Surname) => {
                var student = this.state.currentStudent;
                student.Name = Name ? Name : this.state.currentStudent.Name;
                student.Surname = Surname ? Surname : this.state.currentStudent.Surname;
                this.props.handleChangeDetails(this.state.currentIndex, student);
                this.setState({ currentStudent: null, currentIndex: null, Name: null, Surname: null });
        }
        deleteStudent = () => {
            this.props.deleteStudent(this.state.currentIndex);
            this.setState({ currentStudent: null, currentIndex: null});
        }

        render() {
                return (
                    <div>
                    {this.state.currentStudent && <button style={{marginTop: '20px', marginBottom: '0px', paddingBottom: '0'}} className="btn-primary" onClick={() => this.deleteStudent()}>Delete</button>}
                        <div>
                           
                                <table className="table-bordered" style={{ border: '1px solid', margin: '200px' }}>
                                        <tbody>
                                        {this.props.students.map((student, index) => <tr key={index}><td
                                        onClick={() => this.handleClick(student, index)}><StudentItem key={index} student={student} /></td></tr>)}
                                        </tbody>
                                </table>
                                
                                {this.state.currentStudent && <EditStudentDetails handleSubmit={this.handleSubmit} />}
                                
                        </div>
                        </div>
                )
        }
}



