import { useState } from "react";
import Button from "../../components/Button";
import InputGroup from "../../components/InputGroup";

type Manga = {
	title: string;
	author: string;
};

const NewManga = () => {
	const [manga, setManga] = useState<Manga>({
		title: "",
		author: "",
	});

	const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
		setManga({
			...manga,
			[e.target.name]: e.target.value,
		});
	};

	const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
		e.preventDefault();
		try {
			const response = await fetch("http://localhost:8080/manga", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(manga),
			});

			if (response.ok) {
				alert("Mangá adicionado com sucesso!");
				setManga({
					title: "",
					author: "",
				});
			}
		} catch (error) {
			console.error(error);
		}
	};

	return (
		<>
			<h1 className="title">Novo Mangá</h1>
			<form onSubmit={handleSubmit}>
				<div className="w-full float-end">
					<InputGroup
						label="Título"
						name="title"
						value={manga.title}
						onChange={handleChange}
					/>
					<InputGroup
						label="Autor"
						name="author"
						value={manga.author}
						onChange={handleChange}
					/>
				</div>
				<Button text="Adicionar" style="float-right" />
			</form>
		</>
	);
};

export default NewManga;
