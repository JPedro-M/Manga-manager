import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Sidebar from "./components/sidebar/Sidebar";
import MangaList from "./pages/manga/MangaList";
import NewManga from "./pages/manga/MangaAdd";

function App() {
	return (
		<Router>
			<div className="flex h-screen">
				<Sidebar />
				<div className="bg-background text-text-primary flex-1 p-8">
					<Routes>
						<Route path="/" element={<h1>Home</h1>} />
						<Route path="/mangas/list" element={<MangaList />} />
						<Route path="/mangas/add" element={<NewManga />} />
						<Route
							path="/mangas/history"
							element={<h1>Histórico</h1>}
						/>
					</Routes>
				</div>
			</div>
		</Router>
	);
}

export default App;
