import React from 'react';

export const StudentItem = (props) => {
    return <div>{props.student.Name}     {props.student.Surname}</div>
}