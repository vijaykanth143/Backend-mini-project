import React from 'react';
import {Jumbotron} from 'react-bootstrap';

class Dashboard extends React.Component{
    render(){
    return (
        <Jumbotron className="bg-dark text-white">
            <center><h1>You are Logged In</h1></center>
        </Jumbotron>
    );
}
}
export default Dashboard;