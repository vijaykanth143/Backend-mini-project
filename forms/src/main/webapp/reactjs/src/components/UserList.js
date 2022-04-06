import React from "react";
import {Card,Table} from "react-bootstrap"
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList} from "@fortawesome/free-solid-svg-icons"
import axios from "axios";

class UserList extends React.Component {
	constructor(props){
		super(props);
		this.state={
			user: []
		}
	}
	componentDidMount(){
this.findAllUsers();
	}
findAllUsers(){
	axios.get("http://localhost:8080/forms")
    		.then(response => response.data)
    		.then((data) => {
    			this.setState({user:data});
    		})}
	render(){
		return (
			<Card className={"border border-dark bg-dark text-white"}>
			<Card.Header><FontAwesomeIcon icon={faList} /> Registered Users</Card.Header>
			<Card.Body>
			<Table bordered hover striped variant="dark">
			<thead>
    <tr>
      <th>FirstName</th>
      <th>LastName</th>
      <th>Password</th>
      <th>Email</th>
    </tr>
  </thead>
  <tbody>
  {
  this.state.user.length === 0  ?
    <tr align="center">
      <td colSpan="6">Registered Users .</td>
    </tr> :
    this.state.user.map((user) => (
    <tr key={user.id}>
    <td>{user.firstName}</td>
    <td>{user.lastName}</td>
    <td>{user.password}</td>
    <td>{user.email}</td>
    </tr>
)   )
}
  </tbody>
			</Table>
			</Card.Body>
			</Card>
			)
	}
}
export default UserList;