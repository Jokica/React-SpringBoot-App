import React from 'react';

export const StudentItem = (props) => {
    return <div>{props.student.name}     {props.student.lastName}</div>
}