import React,{useState} from 'react';
import './App.css';
import {Container, Row, Col} from "react-bootstrap"
import Navigation from "./components/Navigation"
import Welcome from "./components/Welcome"
import Dashboard from "./components/Dashboard"
import UserList from "./components/UserList"
import Register from "./components/Register"
import Home from "./pages/Home"
import Admin from "./pages/Admin"
import Login from "./components/Login"
import Footer from "./components/Footer"
import {BrowserRouter as Router, Switch,Route} from "react-router-dom"
import PrivateRoute from "./PrivateRoute"
import {AuthContext} from "./context/auth"

function App(props) {
const existingTokens = JSON.parse(localStorage.getItem("tokens"));
const [authTokens,setAuthTokens]=useState(existingTokens);
const setTokens = (data) => {
localStorage.setItem("tokens",JSON.stringify(data));
setAuthTokens(data);
}
const marginTop={
marginTop:"20px"
};
  return (
  <AuthContext.Provider value={{authTokens, setAuthTokens:setTokens}}>
    <Router>
        <Navigation />
        <Container>
        <Row>
        <Col lg={12} style={marginTop}>
<Switch>
<Route path="/" exact component={Welcome}/>
<Route path="/add" exact component={Register}/>
<Route path="/list" exact component={UserList}/>
<Route path="/login" exact component={Login}/>
<Route path="/dashboard" exact component={Dashboard}/>
<Route exact path="/home" exact component={Home}/>
<PrivateRoute path="/admin" exact component={Admin}/>
</Switch>
</Col>
        </Row>
        </Container>
        <Footer />
</Router>
</AuthContext.Provider>
  );
}
export default App;