type ButtonProps = {
	text: string;
	style?: string;
};

const Button = ({ text, style }: ButtonProps) => {
	const defaultStyle =
		"btn bg-purple-dark rounded-md w-fit px-4 py-2 text-text-primary cursor-pointer hover:bg-purple-hover border-1 border-border";
	const mergedStyle = style ? `${defaultStyle} ${style}` : defaultStyle;

	return <button className={mergedStyle}>{text}</button>;
};

export default Button;
