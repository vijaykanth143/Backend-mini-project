import React from 'react';
import {Jumbotron} from 'react-bootstrap';

class Welcome extends React.Component{
    render(){
    return (
        <Jumbotron className="bg-dark text-white">
            <center><h1>WELCOME</h1></center>
        </Jumbotron>
    );
}
}
export default Welcome;