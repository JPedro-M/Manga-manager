import { useEffect, useState } from "react";
import Table from "../../components/DataTable";

type Manga = {
	id: number;
	title: string;
	author: string;
};

const MangaList = () => {
	const [mangas, setMangas] = useState<Manga[]>([]);
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		const fetchMangas = async () => {
			try {
				const response = await fetch("http://localhost:8080/manga");
				const data = await response.json();
				setMangas(data);
			} catch (error) {
				console.error(error);
			} finally {
				setLoading(false);
			}
		};

		fetchMangas();
	}, []);

	const columns = [
		{ accessorKey: "title", header: "Título", size: 60 },
		{ accessorKey: "author", header: "Autor", size: 40 },
	];

	return (
		<>
			<h1 className="title">Mangás Cadastrados</h1>
			{loading ? (
				<p>Carregando...</p>
			) : (
				<Table data={mangas} columns={columns} />
			)}
		</>
	);
};

export default MangaList;
