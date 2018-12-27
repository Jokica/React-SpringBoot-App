import React, { Component } from 'react';

export class EditStudentDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
            Name: "",
            Surname: ""
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }


    handleInputChange({ target }) {
        this.setState({
            [target.name]: target.value
        })
    }

    handleSubmit = () => {
        this.props.handleSubmit(this.state.Name, this.state.Surname);
        this.setState({ Name: "", Surname: "" })
    }
    
    render() {
        return (
            <div style={{marginLeft: '200px', marginTop: '-100px', marginBottom: '100px'}} className="form-inline">
                <input type="text"
                    name="Name"
                    placeholder="Insert new name"
                    value={this.state.Name}
                    onChange={this.handleInputChange}
                    className="form-control" />
                <input type="text"
                    name="Surname"
                    placeholder="Insert new surname"
                    value={this.state.Surname}
                    onChange={this.handleInputChange} 
                    className="form-control"/>
                <button className="btn-primary" onClick={() => this.handleSubmit()}>Submit</button>
            </div>
            
        )
    }
}