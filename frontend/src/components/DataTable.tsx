import {
	useReactTable,
	getCoreRowModel,
	flexRender,
} from "@tanstack/react-table";
import React from "react";

type TableStyles = {
	container?: string;
	table?: string;
	thead?: string;
	tbody?: string;
	tfoot?: string;
	th?: string;
	tr?: string;
	td?: string;
};

type DataTableProps = {
	data: any[];
	columns: any[];
	styles?: TableStyles;
};

const DataTable: React.FC<DataTableProps> = ({ data, columns, styles }) => {
	const defaultStyles: TableStyles = {
		container: "overflow-x-auto",
		table: "w-full text-left border-collapse bg-background",
		thead: "text-text-primary border-b border-text-secondary",
		tbody: "bg-purple/10",
		tfoot: "text-text-primary border-t border-text-secondary",
		th: "px-4 py-2",
		tr: "border-y border-text-secondary odd:bg-black/10 even:bg-black/20 hover:bg-purple-hover/10",
		td: "px-4 py-2",
	};

	const mergedStyles = { ...defaultStyles, ...styles };

	const table = useReactTable({
		data,
		columns,
		getCoreRowModel: getCoreRowModel(),
	});

	return (
		<div className={mergedStyles.container}>
			<table className={mergedStyles.table}>
				<thead className={mergedStyles.thead}>
					{table.getHeaderGroups().map((headerGroup) => (
						<tr key={headerGroup.id}>
							{headerGroup.headers.map((header) => (
								<th
									key={header.id}
									className={mergedStyles.th}
									style={{
										width: `${header.column.columnDef.size}%`,
									}}
								>
									{flexRender(
										header.column.columnDef.header,
										header.getContext()
									)}
								</th>
							))}
						</tr>
					))}
				</thead>
				<tbody className={mergedStyles.tbody}>
					{table.getRowModel().rows.map((row) => (
						<tr key={row.id} className={mergedStyles.tr}>
							{row.getVisibleCells().map((cell) => (
								<td key={cell.id} className={mergedStyles.td}>
									{flexRender(
										cell.column.columnDef.cell,
										cell.getContext()
									)}
								</td>
							))}
						</tr>
					))}
				</tbody>
				<tfoot>
					{table.getHeaderGroups().map((headerGroup) => (
						<tr key={headerGroup.id}>
							{headerGroup.headers.map((header) => (
								<td
									key={header.id}
									className={mergedStyles.th}
									style={{
										width: `${header.column.columnDef.size}%`,
									}}
								>
									{flexRender(
										header.column.columnDef.header,
										header.getContext()
									)}
								</td>
							))}
						</tr>
					))}
				</tfoot>
			</table>
		</div>
	);
};

export default DataTable;
