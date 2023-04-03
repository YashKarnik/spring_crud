import React, { FormEvent, useState } from 'react';
import { requestHelper } from '../../service/http';

export default function Register() {
  async function registerUser(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    console.log({ email, password, username });
    const json = await requestHelper('post', 'user/register', {
      email,
      password,
      username,
    });

    console.log(json);
  }

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [username, setUsername] = useState('');
  return (
    <div>
      <h1>Register</h1>
      <form onSubmit={registerUser}>
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
        <input
          type='text'
          name='username'
          id='username'
          value={username}
          placeholder='Username'
          onChange={(e) => setUsername(e.target.value)}
        />
        <button type='submit'>Submit</button>
      </form>
      <a href='/login'>Login</a>
    </div>
  );
}
