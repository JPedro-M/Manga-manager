import Input from "./Input";

type InputGroupStyles = {
	container?: string;
	label?: string;
	input?: string;
};

type InputGroupProps = {
	label: string;
	name: string;
	value: string;
	onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
	style?: InputGroupStyles;
	placeholder?: string;
};

const InputGroup = ({
	label,
	name,
	value,
	onChange,
	style,
	placeholder,
}: InputGroupProps) => {
	const defaultContainerStyle = "w-3/10 float-left mb-4 mx-2";
	const defaultLabelStyle = "text-text-primary";

	const mergedContainerStyle = style?.container
		? `${defaultContainerStyle} ${style.container}`
		: defaultContainerStyle;

	const mergedLabelStyle = style?.label
		? `${defaultLabelStyle} ${style.label}`
		: defaultLabelStyle;

	const inputStyle = style?.input ? style.input : "";

	return (
		<div className={mergedContainerStyle}>
			<label htmlFor={name} className={mergedLabelStyle}>
				{label}
			</label>
			<Input
				type="text"
				name={name}
				placeholder={placeholder ? placeholder : `Digite o ${label}`}
				value={value}
				onChange={onChange}
				style={inputStyle}
			/>
		</div>
	);
};

export default InputGroup;
