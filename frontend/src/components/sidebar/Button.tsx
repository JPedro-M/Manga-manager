import { LucideIcon } from "lucide-react";
import React from "react";

type ButtonProps = {
	icon: LucideIcon;
	text: string;
	onClick?: () => void;
	className?: string;
	iconClassName?: string;
	textClassName?: string;
	isOpen?: boolean;
};

const Button: React.FC<ButtonProps> = ({
	icon: Icon,
	text,
	onClick,
	className,
	iconClassName,
	textClassName,
	isOpen = false,
}) => {
	return (
		<button
			onClick={onClick}
			className={`${className} hover:bg-purple-hover transition-colors duration-200 flex pt-3 pb-3 pl-4 pr-4 w-full cursor-pointer`}
		>
			{Icon && (
				<Icon
					className={`${iconClassName} w-6 h-6 transition-all mb-auto mt-auto ${
						isOpen ? null : "m-auto"
					}`}
				/>
			)}
			{isOpen ? (
				<span className={`${textClassName} pl-2`}>{text}</span>
			) : (
				""
			)}
		</button>
	);
};

export default Button;
