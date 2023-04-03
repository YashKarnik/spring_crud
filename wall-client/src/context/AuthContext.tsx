import React, { useContext, createContext, useState } from 'react';

const AuthContext = createContext<any>(null);

export const useAuthContext = (): {
  authToken: string;
  setAuthToken: React.Dispatch<React.SetStateAction<string>>;
} => useContext(AuthContext);

function getCookie(name: string) {
  const value = document.cookie;
  return value
    .split(';')
    .filter((e) => e.trim().startsWith(name))
    .pop()
    ?.split('=')
    .pop();
}

export function AuthContextProvider(props: any) {
  const [authToken, setAuthToken] = useState(getCookie('AUTH_COOKIE'));
  return (
    <AuthContext.Provider value={{ authToken, setAuthToken }}>
      {props.children}
    </AuthContext.Provider>
  );
}
