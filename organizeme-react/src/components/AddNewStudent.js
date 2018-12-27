import React, { Component } from 'react';

export class AddNewStudent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            Name: "",
            Surname: "",
            Index: "",
            Nasoka: ""
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }


    handleInputChange({ target }) {
        this.setState({
            [target.name]: target.value
        })
    }

    handleSubmit = () => {
        
        this.props.handleSubmit(this.state.Name, this.state.Surname, this.state.Index, this.state.Nasoka);
        this.setState({ Name: "", Surname: "", Index: "", Nasoka: "" })
        
    }
    render() {
        return (
        
            <div style={{marginLeft: '200px', marginTop: '-50px'}} className="form-inline">
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
                    className="form-control" />
                <input type="text"
                    name="Index"
                    placeholder="Insert new index"
                    value={this.state.Index}
                    onChange={this.handleInputChange} 
                    className="form-control"/>
                <input type="text"
                    name="Nasoka"
                    placeholder="Insert new nasoka"
                    value={this.state.Nasoka}
                    onChange={this.handleInputChange}
                    className="form-control " />
                <button className="btn-primary" onClick={() => this.handleSubmit()}>Add new student</button>
            </div>
           
        )
    }
}