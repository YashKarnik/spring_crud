import React, { FormEvent, useState } from 'react';
import UserService from '../../service/UserService';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const userService = new UserService();
    try {
      await userService.loginUser(email, password);
      navigate('/blogs');
    } catch (e: any) {
      console.log(e.message);
      setError(e.message);
    }
  }

  return (
    <div>
      {error !== '' && <p>{error}</p>}
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <input
          type='email'
          name='email'
          id='email'
          placeholder='Email'
          onChange={(e) => setEmail(e.target.value)}
          value={email}
        />
        <input
          type='password'
          name='password'
          id='password'
          placeholder='Password'
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button>Submit</button>
      </form>
      <a href='/register'>Register</a>
    </div>
  );
}

export default Login;
