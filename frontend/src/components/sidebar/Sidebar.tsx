import { useState } from "react";
import { Link } from "react-router-dom";
import { History, ListCheck, Menu, Plus } from "lucide-react";
import Button from "./Button";
import { BookOpenIcon } from "@heroicons/react/16/solid";

function Sidebar() {
	const [isOpen, setIsOpen] = useState<boolean>(
		() => localStorage.getItem("isOpen") === "true"
	);

	const toggleSidebar = () => {
		setIsOpen(!isOpen);
		localStorage.setItem("isOpen", String(!isOpen));
	};

	return (
		<div
			className={`h-screen bg-background-secondary text-text-primary transition-all duration-300 ease-in-out ${
				isOpen ? "w-64" : "w-16"
			}`}
		>
			<div className="flex">
				{isOpen ? (
					<Link to="/" className="w-full">
						<button
							className={`hover:bg-purple-hover transition-colors duration-200 flex p-4 w-full cursor-pointer`}
						>
							<BookOpenIcon className="w-6 h-6 mt-auto mb-auto" />
							<span className={`pl-2 text-xl`}>Mangás</span>
						</button>
					</Link>
				) : null}
				<button
					onClick={toggleSidebar}
					className={`hover:bg-purple-hover transition-colors duration-200 flex p-4 cursor-pointer ${
						isOpen ? "w-16" : "w-full"
					}`}
				>
					<Menu className={`w-6 h-6 m-auto`} />
				</button>
			</div>
			<hr />
			<Link to="/mangas/list">
				<Button
					text="Lista de Mangás"
					icon={ListCheck}
					isOpen={isOpen}
					textClassName="text-l"
				/>
			</Link>
			<Link to="/mangas/add">
				<Button
					text="Adicionar Mangá"
					icon={Plus}
					isOpen={isOpen}
					textClassName="text-l"
				/>
			</Link>
			<Link to="/mangas/history">
				<Button
					text="Histórico"
					icon={History}
					isOpen={isOpen}
					textClassName="text-l"
				/>
			</Link>
		</div>
	);
}

export default Sidebar;
