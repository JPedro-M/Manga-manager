type InputProps = {
	type: string;
	placeholder: string;
	value: string;
	name: string;
	onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
	style?: string;
};

const Input = ({ type, placeholder, value, name, onChange, style }: InputProps) => {
	const defaultStyle =
		"input w-full rounded-md px-4 py-2 border-1 border-border";
	const mergedStyle = style ? `${defaultStyle} ${style}` : defaultStyle;

	return (
		<input
			type={type}
			name={name}
			placeholder={placeholder}
			value={value}
			onChange={onChange}
			className={mergedStyle}
		/>
	);
};

export default Input;
