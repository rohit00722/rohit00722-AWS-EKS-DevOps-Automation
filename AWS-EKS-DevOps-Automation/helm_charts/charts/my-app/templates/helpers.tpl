{{- define "my-app.fullname" -}}
{{ .Release.Name }}-my-app
{{- end }}

{{- define "my-app.labels" -}}
app: my-app
release: {{ .Release.Name }}
{{- end }}

{{- define "my-app.selectorLabels" -}}
app: my-app
release: {{ .Release.Name }}
{{- end }}
