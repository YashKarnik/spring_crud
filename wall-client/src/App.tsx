import React from 'react';
import Login from './components/Login/Login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Register from './components/Register/Register';
import { AuthContextProvider } from './context/AuthContext';
import Blogs from './components/blog/Blogs';
import Blog from './components/blog/Blog';
import UpdateBlog from './components/blog/UpdateBlog';
function App() {
  return (
    <AuthContextProvider>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Register />}>
            <Route path='/register' element={<Register />} />
          </Route>
          <Route path='/login' element={<Login />} />
          <Route path='/blogs' element={<Blogs />} />
          <Route path='/blogs/:blogid' element={<Blog />} />
          <Route path='/blogs/:blogid/update' element={<UpdateBlog />} />
        </Routes>
      </BrowserRouter>
    </AuthContextProvider>
  );
}

export default App;
