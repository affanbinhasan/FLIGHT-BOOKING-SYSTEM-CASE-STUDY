import React, { Component } from 'react'

export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
          email: "",
          password: ""
        };
      }

      handleSubmit(event) {
        event.preventDefault();
        const { email, password } = this.state;
        // console.log(this.state);
    
        axios
          .post(
            "https://x60t8.sse.codesandbox.io/login",
            {
              username: email,
              password: password
            }
            // { withCredentials: true }
          )
          .then(res => {
            console.log(res);
            window.localStorage.setItem("token", res.data.token);
            this.props.history.push("/home");
            // return <Redirect to="/home" />;
          })
          .catch(err => {
            console.log(err);
          });
      } 

      componentDidMount() {
        if (window.localStorage.getItem("token")) {
          axios.defaults.headers.common[
            "Authorization"
          ] = window.localStorage.getItem("token");
          axios
            .post("https://x60t8.sse.codesandbox.io/islogin")
            .then(res => {
              if (res.data.status) {
               
                this.props.history.push("/home");
              }
            })
            .catch(res => console.log(res));
        }
      } 
      
      render() {
        return (
          <div>
            <form onSubmit={this.c}>
              <h1>welcome to log in!</h1>
              <br />
              <input
                type="email"
                name="email"
                placeholder="Email"
                defaultValue={this.state.email}
                onChange={e => {
                  this.setState({ email: e.target.value });
                }}
              />
              <br />
              <br />
              <input
                type="password"
                name="password"
                placeholder="Password"
                defaultValue={this.state.password}
                onChange={e => {
                  this.setState({ password: e.target.value });
                }}
              />
              <br />
              <br />
              <button type="submit"> Login </button>
            </form>
          </div>
        );
      } 
}

export default Login