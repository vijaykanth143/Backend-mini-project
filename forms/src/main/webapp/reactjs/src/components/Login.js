	import React, { Component } from "react";
	import axios from "axios";
	import {Card,Form,Button,Col} from "react-bootstrap"
	import MyToast from "./MyToast"
    import {Link} from "react-router-dom"

	export default class Login extends Component {
	  constructor(props) {
	    super(props);
	    this.state = {
	      email: "",
	      password: "",
	      loginErrors: ""
	    };
	    this.handleSubmit = this.handleSubmit.bind(this);
	    this.handleChange = this.handleChange.bind(this);
	  }
	  handleChange(event) {
	    this.setState({
	      [event.target.name]: event.target.value
	    });
	  }
	  handleSubmit(event) {
	    const { email, password } = this.state;
	    axios
	      .post(
	        "http://localhost:8080/forms",
	        {
	            email: email,
	            password: password
	        },
	      )
	      .then(response => {
	        if (response.data.logged_in) {
	          this.props.handleSuccessfulAuth(response.data);
	        }
	      })
	      .catch(error => {
	        console.log("login error", error);
	      });
	    event.preventDefault();
	  }
	  render() {
	  const {email,password}=this.state;
	    return (
	    	<div>
	    	<div style={{"display":this.state.show ? "block" : "none"}}>
	    	 <MyToast children = {{show:this.state.show, message:"Login Successfull."}}/>
	    	 </div>
	    	 <Card className={"border border-dark bg-dark text-white"}>
	         		<Card.Header>Login</Card.Header>
	         		<Form onReset={this.resetBook} onSubmit={this.handleSubmit} id="bookFormId">
	         		<Card.Body>
	         		<Form.Row>
	         		<Form.Group as= {Col} controlId="formGridfirstName">
	         		<Form.Label>Email</Form.Label>
	         		<Form.Control required autoComplete="off"
	         		type="test"
	         		name="email"
	         		value={email}
	         		onChange={this.handleChange}
	         		className={"bg-dark text-white"}
	         		placeholder="Enter Email" />
	         		</Form.Group>
	         		<Form.Group as= {Col} controlId="formGridlastName">
	         		<Form.Label>Password</Form.Label>
	         		<Form.Control required autoComplete="off"
	         		type="test"
	         		name="password"
	         		value={password}
	         		onChange={this.handleChange}
	         		className={"bg-dark text-white"}
	         		placeholder="Enter Password" />
	         		</Form.Group>
	         		</Form.Row>
	         		<Card.Footer style={{"textAlign":"right"}}>
	         		 <Link to={"Dashboard"} >
	                     		<Button size="sm" variant="primary" type="submit">
	                     		Login
	                     		</Button>
	                     		</Link>
	                     		</Card.Footer>
	                                 		</Card.Body>
	                                 		</Form>
	                              <center>   		<Link to="/add">Dont have an Account ? </Link></center>
	                                 		</Card>
	                            	</div>
	);
	}
	}
