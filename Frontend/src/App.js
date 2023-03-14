import logo from "./logo.svg";
import "./App.css";
import Index from "./components/Index";
import HomePage from "./components/navbar/HomePage";
import PageRouter from "./components/routers/PageRouter";

function App() {
  return (
    <div className="App">
      <PageRouter></PageRouter>
    </div>
  );
}

export default App;
